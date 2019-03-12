/**
 *
 */
package com.gmail.ishara.ui.crud;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gmail.ishara.app.security.CurrentUser;
import com.gmail.ishara.backend.data.entity.Order;
import com.gmail.ishara.backend.data.entity.Product;
import com.gmail.ishara.backend.data.entity.User;
import com.gmail.ishara.backend.service.OrderService;
import com.gmail.ishara.backend.service.ProductService;
import com.gmail.ishara.backend.service.UserService;
import com.gmail.ishara.ui.views.storefront.StorefrontView;

@Configuration
public class PresenterFactory {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CrudEntityPresenter<Product> productPresenter(ProductService crudService, CurrentUser currentUser) {
		return new CrudEntityPresenter<>(crudService, currentUser);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CrudEntityPresenter<User> userPresenter(UserService crudService, CurrentUser currentUser) {
		return new CrudEntityPresenter<>(crudService, currentUser);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public EntityPresenter<Order, StorefrontView> orderEntityPresenter(OrderService crudService, CurrentUser currentUser) {
		return new EntityPresenter<>(crudService, currentUser);
	}

}
