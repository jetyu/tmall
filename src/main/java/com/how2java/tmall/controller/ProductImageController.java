/**
 * @Title: ProductImageController.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.UploadedImageFile;

/**
 * @Name: ProductImageController
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
@Controller
@RequestMapping("")
public class ProductImageController {
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    /**
     * 定义logger
     */
    private Logger logger = LoggerFactory.getLogger(ProductImageController.class);

    @RequestMapping("admin_productImage_list")
    public String list(int pid, Model model) {
        Product p = productService.getProductById(pid);
        List<ProductImage> pisSingle = productImageService.listProductImage(pid, ProductImageService.TYPE_SINGLE);
        List<ProductImage> pisDetail = productImageService.listProductImage(pid, ProductImageService.TYPE_DETAIL);
        Category c = categoryService.getCategoryById(p.getCid());
        model.addAttribute("p", p);
        model.addAttribute("c", c);
        model.addAttribute("pisSingle", pisSingle);
        model.addAttribute("pisDetail", pisDetail);

        return "admin/listProductImage";
    }

    @RequestMapping("admin_productImage_add")
    public String insertProductImage(ProductImage pi, Model model, HttpSession session, UploadedImageFile uploadedImageFile) {
        logger.info("调用方法了insertPI");
        productImageService.insertProductImage(pi);
        String fileName = pi.getId() + ".jpg";
        String imageFolder;
        String smallImageFolder = null;
        String middleImageFolder = null;
        if (ProductImageService.TYPE_SINGLE.equals(pi.getType())) {
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            smallImageFolder = session.getServletContext().getRealPath("img/productSingle_small");
            middleImageFolder = session.getServletContext().getRealPath("img/productSingle_middle");
        } else {
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
        }

        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdirs();
        try {
            uploadedImageFile.getImage().transferTo(f);
            BufferedImage img = ImageUtil.change2jpg(f);
            ImageIO.write(img, "jpg", f);

            if (ProductImageService.TYPE_SINGLE.equals(pi.getType())) {
                File smallFile = new File(smallImageFolder, fileName);
                File middleFile = new File(middleImageFolder, fileName);

                ImageUtil.resizeImage(f, 56, 56, smallFile);
                ImageUtil.resizeImage(f, 217, 190, middleFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:admin_productImage_list?pid=" + pi.getPid();
    }

    @RequestMapping("admin_productImage_delete")
    public String delete(int id, HttpSession session) {
        ProductImage pi = productImageService.getProductImageById(id);

        String fileName = pi.getId() + ".jpg";
        String imageFolder;
        String imageFolder_small = null;
        String imageFolder_middle = null;

        if (ProductImageService.TYPE_SINGLE.equals(pi.getType())) {
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small = session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle = session.getServletContext().getRealPath("img/productSingle_middle");
            File imageFile = new File(imageFolder, fileName);
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            imageFile.delete();
            f_small.delete();
            f_middle.delete();

        } else {
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
            File imageFile = new File(imageFolder, fileName);
            imageFile.delete();
        }

        productImageService.deleteProductImage(id);

        return "redirect:admin_productImage_list?pid=" + pi.getPid();
    }
}
