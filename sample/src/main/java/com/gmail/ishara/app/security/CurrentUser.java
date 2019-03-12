package com.gmail.ishara.app.security;

import com.gmail.ishara.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}
