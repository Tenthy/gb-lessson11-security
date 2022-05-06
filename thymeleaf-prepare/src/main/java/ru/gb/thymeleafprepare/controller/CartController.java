package ru.gb.thymeleafprepare.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.thymeleafprepare.entity.Cart;
import ru.gb.thymeleafprepare.entity.Product;
import ru.gb.thymeleafprepare.service.CartService;
import ru.gb.thymeleafprepare.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping
    public String getProductsIntoCart(Model model) {
        Cart cart = cartService.findById(1L);
        model.addAttribute("cart", cart.findAllProductInCart());
        return "product-list-into-cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable(name = "productId") Long productId) {
        Product product = productService.findById(productId);
        Cart cart = cartService.findById(1L);
        cart.deleteProduct(product);
        cartService.save(cart);
        return "redirect:/cart";
    }
}
