package com.sheygam.loginarchitectureexample.di.addContact;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Kate on 18.02.2018.
 */
@Scope
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AddContactScope {
}
