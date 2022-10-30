package com.spring.mongo.service.creatinglist;

import com.spring.mongo.dao.model.stackoverflow.StackOverFlowWebsite;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * данный класс, создает списко объектов, с нужными данными
 */
@Component
public class StackOverFlowList {

    private static List<StackOverFlowWebsite> items = new ArrayList<>();

    static {

        items.add(StackOverFlowWebsite.newBuilder()
                .id("stackoverflow.com")
                .iconImageUrl("http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico")
                .website("http://serverfault.com")
                .title("Stackoverflow website (StackExchange)")
                .description("for professional and enthusiast programmers")
                .build());

        items.add(StackOverFlowWebsite.newBuilder()
                .id("serverfault")
                .iconImageUrl("http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico")
                .website("http://serverfault.com")
                .title("Ask Different (StackExchange)")
                .description("for system and network administrators")
                .build());

        items.add(StackOverFlowWebsite.newBuilder()
                .id("superuser")
                .iconImageUrl("http://cdn.sstatic.net/Sites/superuser/img/favicon.ico")
                .website("http://superuser.com")
                .title("Super User (StackExchange)")
                .description("for computer enthusiasts and power users")
                .build());

        items.add(StackOverFlowWebsite.newBuilder()
                .id("apple")
                .iconImageUrl("http://cdn.sstatic.net/Sites/askubuntu/img/favicon.ico")
                .website("http://askubuntu.com")
                .title("Ask Ubuntu (StackExchange)")
                .description("for Ubuntu users and developers")
                .build());

        items.add(StackOverFlowWebsite.newBuilder()
                .id("android")
                .iconImageUrl("http://cdn.sstatic.net/Sites/android/img/favicon.ico")
                .website("http://android.stackexchange.com")
                .title("Android Enthusiasts (StackExchange)")
                .description("for enthusiasts and power users of the Android operating system")
                .build());

        items.add(StackOverFlowWebsite.newBuilder()
                .id("ru.stackoverflow")
                .iconImageUrl("http://cdn.sstatic.net/Sites/ru/img/favicon.ico")
                .website("http://ru.stackoverflow.com")
                .title("Stack Overflow нa pycckom (StackExchange)")
                .description("для программистов")
                .build());
    }

    public StackOverFlowList() {
    }

    public static List<StackOverFlowWebsite> getItems() {
        return items;
    }
}
