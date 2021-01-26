package com.doubles.devlog.article.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doubles.devlog.article.domain.ArticleVO;
import com.doubles.devlog.article.service.ArticleService;
import com.doubles.devlog.commons.paging.Criteria;
import com.doubles.devlog.commons.paging.PageMaker;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final ArticleService articleService;

    @Inject
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    // 등록 페이지 이동
    @GetMapping(value = "/write")
    public String writeGET() {

        logger.info("write GET...");

        return "/article/write";
    }
    
    // 등록 처리
    @PostMapping(value = "/write")
    public String writePOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception {

        logger.info("write POST...");
        logger.info(articleVO.toString());
        articleService.create(articleVO);
        redirectAttributes.addFlashAttribute("msg", "regSuccess");

        return "redirect:/article/list";
    }
    
    // 목록 페이지 이동(페이징)
    @GetMapping(value = "/list")
    public String list(Model model, Criteria criteria) throws Exception {

        logger.info("list ...");
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(criteria);
        pageMaker.setTotalCount(articleService.countArticles(criteria));

        model.addAttribute("articles", articleService.listCriteria(criteria));
        model.addAttribute("pageMaker", pageMaker);

        return "/article/list";
    }
    
    // 조회 페이지 이동
    @GetMapping(value = "/read")
    public String read(@RequestParam("articleNo") int articleNo, @ModelAttribute("criteria") Criteria criteria, Model model) throws Exception {

        logger.info("read ...");
        model.addAttribute("article", articleService.read(articleNo));

        return "/article/read";
    }

    // 수정 페이지 이동
    @GetMapping(value = "/modify")
    public String modifyGET(@RequestParam("articleNo") int articleNo, @ModelAttribute("criteria") Criteria criteria, Model model) throws Exception {

        logger.info("modifyGet ...");
        model.addAttribute("article", articleService.read(articleNo));

        return "/article/modify";
    }
    
    // 수정 처리
    @PostMapping(value = "/modify")
    public String modifyPOST(ArticleVO articleVO, Criteria criteria, RedirectAttributes redirectAttributes) throws Exception {

        logger.info("modifyPOST ...");
        articleService.update(articleVO);
        redirectAttributes.addFlashAttribute("msg", "modSuccess");
        redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
        redirectAttributes.addFlashAttribute("msg", "modSuccess");

        return "redirect:/article/list";
    }
    
    // 삭제 처리
    @PostMapping(value = "/remove")
    public String remove(@RequestParam("articleNo") int articleNo, Criteria criteria, RedirectAttributes redirectAttributes) throws Exception {

        logger.info("remove ...");
        articleService.delete(articleNo);
        redirectAttributes.addAttribute("page", criteria.getPage());
        redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/article/list";
    }

}