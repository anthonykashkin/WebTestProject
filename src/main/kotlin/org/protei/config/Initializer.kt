package org.protei.config

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext
import javax.servlet.ServletException



class Initializer : WebApplicationInitializer
{
    private val DISPATCHER_SERVLET_NAME = "dispatcher"

    @Throws(ServletException::class)
    override fun onStartup(servletContext: ServletContext) {
        val ctx = AnnotationConfigWebApplicationContext()
        // регистрируем конфигурацию созданую высше
        ctx.register(WebAppConfig::class.java)
        // добавляем в контекст слушателя с нашей конфигурацией
        servletContext.addListener(ContextLoaderListener(ctx))

        ctx.servletContext = servletContext

        // настраиваем маппинг Dispatcher Servlet-а
        val servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, DispatcherServlet(ctx))
        servlet.addMapping("/")
        servlet.setLoadOnStartup(1)
    }
}