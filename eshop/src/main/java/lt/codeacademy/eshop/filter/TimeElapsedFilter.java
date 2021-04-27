package lt.codeacademy.eshop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class TimeElapsedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // do some logic before
        log.trace("------------------------- TimeElapsedFilter started! -------------------------");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // call rest of the chain
        filterChain.doFilter(servletRequest, servletResponse);

        stopWatch.stop();

        // do some logic after
        log.trace("------------------------- Execution time was: {} ms -------------------------", stopWatch.getLastTaskTimeMillis());
    }
}
