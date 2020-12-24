package rabbionRules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengLiang
 * @description 自定义负载均衡规则    轮询 随机 。。。。
 * @date 2020/12/24 9:55
 */
@Configuration
public class CustomRules {
    @Bean
    public IRule getCustomRule(){
        return  new RandomRule();
    }
}
