package top.safer.springbootdemo;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author sakura
 */
@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}


	@Bean
	public TomcatServletWebServerFactory tomcatEmbedded() {
		// 主要为了解决上传文件大于100M出现连接重置的问题
		TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory();
		tomcat.addConnectorCustomizers(connector->{
			if((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)){
				((AbstractHttp11Protocol<?>)connector.getProtocolHandler()).setMaxSwallowSize(-1);
			}
		});
		return tomcat;
	}
}
