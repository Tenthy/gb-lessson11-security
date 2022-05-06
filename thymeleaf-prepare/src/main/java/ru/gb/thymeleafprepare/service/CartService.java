package ru.gb.thymeleafprepare.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.thymeleafprepare.dao.CartDao;
import ru.gb.thymeleafprepare.entity.Cart;

@Service
@RequiredArgsConstructor
public class CartService {

    public final CartDao cartDao;

    public Cart save(Cart cart) {
        return cartDao.saveAndFlush(cart);
    }

    public Cart findById(Long id) {
        return cartDao.findById(id).orElse(null);
    }
}
