package com.chuntang.coinfig;

import com.chuntang.bean.Color;
import com.chuntang.bean.ColorFactoryBean;
import com.chuntang.bean.Person;
import com.chuntang.bean.Red;
import com.chuntang.condition.LinuxCondition;
import com.chuntang.condition.MyImoprtSelect;
import com.chuntang.condition.MyImportBeanDefinitionRegistrar;
import com.chuntang.condition.WindowsConditon;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//配置类==配置文件
//类中组件统一设置：满足当前条件，这个类中配置的所有bean才能生效
@Conditional({WindowsConditon.class})
@Configuration  //告诉spring这个个配置类
@Import({Color.class, Red.class, MyImoprtSelect.class, MyImportBeanDefinitionRegistrar.class}) //导入组件默认id时组件的全类名
public class MainConfig2 {


    //默认是单实例
    /*@Scope调整作用域
    * prototype:多实例 ioc容器启动并不会调用方法放在容器中，而是每次获取的时候才会调用方法创建对象
    * singleton：单实例（默认值）ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿
    * request：同一次请求创建一个实例（web环境）
    * session：同一个session创建一个实例（web环境）
    *
    *
    * 懒加载：
    *       单实例bean：默认容器启动的时候创建对象
    *       懒加载：容器启动的时候不创建对象，第一次使用（获取）Bean时创建对象,并进行初始化
     */
//    @Scope("prototype")
    @Lazy
    @Bean(value = "Person")  //给容器中注册一个bean  类型为返回值的类型  id默认用方法名作为id（原来用xml配置时有类型和id ）
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("zhangsan",25,"男");
    }


    /*
     *@Conditional({Condition}) 按照一定条件进行判断，满足条件给容器中注册bean
     * 如果系统是windows给容器注册Bill
     * 如果是linux给容器注册linus
     * */
    @Conditional({WindowsConditon.class})
    @Bean(value = "bill")
    public Person person01(){
        return new Person("Bill Gates",58,"男");
    }
    @Conditional({LinuxCondition.class})
    @Bean(value = "linus")
    public Person person02(){
        return new Person("linus",50,"男");
    }

    /*
    *给容器中注册组件
    * 1.包扫描+组件标注注解（@Controller，@Service,@Repository,@Component）
    * 2.@Bean[导入第三方包里面的组件]
    * 3.@Import[快速的给容器中导入一个组件]
    *     (1)@Import({直接写要导入的容器的组件})：容器中就会注册这个组件，id默认是全类名
    *     (2)ImportSelector:返回需要导入的组件的全类名数组
    *     (3)ImportBeanDefinitionRegistrar:手动注册bean到register中
    * 4.spring提供的FactoryBean（工厂bean）
    *     （1）默认获取到的是工厂bean调用getObject方法创建的对象
    *      (2)要获取工厂bean本身则需要在id前面加一个&标识 例如&colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
