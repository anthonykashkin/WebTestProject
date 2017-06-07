package org.protei.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.view.JstlView
import org.springframework.web.servlet.view.UrlBasedViewResolver

@Configuration
@EnableWebMvc
@ComponentScan("org.protei")
open class WebAppConfig {

    @Bean
    open fun setupViewResolver(): UrlBasedViewResolver {
        val resolver = UrlBasedViewResolver()
        // указываем где будут лежать наши веб-страницы
        resolver.setPrefix("/webapp/")
        // формат View который мы будем использовать
        resolver.setSuffix(".jsp")
        resolver.setViewClass(JstlView::class.java)

        return resolver
    }

}