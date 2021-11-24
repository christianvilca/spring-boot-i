package com.christianvilca.proyecto1.christian;

import com.christianvilca.proyecto1.christian.bean.MyBean;
import com.christianvilca.proyecto1.christian.bean.MyBeanWithDepdency;
import com.christianvilca.proyecto1.christian.bean.MyBeanWithProperties;
import com.christianvilca.proyecto1.christian.component.ComponentDependency;
import com.christianvilca.proyecto1.christian.entity.User;
import com.christianvilca.proyecto1.christian.pojo.UserPojo;
import com.christianvilca.proyecto1.christian.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ChristianApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(ChristianApplication.class);

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDepdency myBeanWithDepdency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;

    private UserRepository userRepository;

    public ChristianApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDepdency myBeanWithDepdency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDepdency = myBeanWithDepdency;
        this.myBeanWithProperties=  myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChristianApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // ejemplosAnteriores();
        saveUserInDataBase();
    }

    private void saveUserInDataBase(){
        User user1 = new User("John", "john@mail.com", LocalDate.of(2021, 03, 20));
        User user2 = new User("Julie", "julie@mail.com", LocalDate.of(2021, 05, 21));
        User user3 = new User("Daniela", "daniela@mail.com", LocalDate.of(2021, 07, 21));
        User user4 = new User("user4", "user4@mail.com", LocalDate.of(2021, 07, 21));
        User user5 = new User("user5", "user5@mail.com", LocalDate.of(2021, 11, 11));
        User user6 = new User("user6", "user6@mail.com", LocalDate.of(2021, 2, 25));
        User user7 = new User("user7", "user7@mail.com", LocalDate.of(2021, 3, 11));
        User user8 = new User("user8", "user8@mail.com", LocalDate.of(2021, 4, 25));
        User user9 = new User("user9", "user9@mail.com", LocalDate.of(2021, 5, 22));
        User user10 = new User("user10", "user10@mail.com", LocalDate.of(2021, 8, 3));
        User user11 = new User("user11", "user11@mail.com", LocalDate.of(2021, 1, 12));
        User user12 = new User("user12", "user12@mail.com", LocalDate.of(2021, 2, 2));

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
        list.stream().forEach(userRepository::save); // por cada de nuestros usuarios hacemos un registro de base de datos
    }

    private void ejemplosAnteriores(){
        componentDependency.saludar();                          // Hola Mundo desde mi componente 2
        myBean.print();                                         // Hola desde mi implementacion propia del bean 2
        myBeanWithDepdency.printWithDependency();               // Hola desde la implementacion de un bean con dependencia
        System.out.println(myBeanWithProperties.function());    // christian vilca
        System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());    // test@mai.com-1234

        // puede estar dentro del try catch
        try {
            int value = 10/0;
            LOGGER.debug("Mi valor: " + value);
        }catch (Exception e){
            LOGGER.error("Esto es un error al divideri por cero " + e.getStackTrace());
        }
        LOGGER.error("Esto es un error del aplicativo");       // 2021-11-24 09:43:06.777 ERROR 14132 --- [  restartedMain] c.c.p.christian.ChristianApplication     : Esto es un error del aplicactivo

    }
}
