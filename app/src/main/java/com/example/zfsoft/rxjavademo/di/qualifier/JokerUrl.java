package com.example.zfsoft.rxjavademo.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 创建日期：2018/7/13 on 15:28
 * 描述:
 * 作者:Ls
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface JokerUrl {
}
