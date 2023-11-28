package com.muhittinu.blogapp.utility;

import com.muhittinu.blogapp.repository.entity.Category;
import com.muhittinu.blogapp.repository.entity.Post;
import com.muhittinu.blogapp.repository.entity.User;
import com.muhittinu.blogapp.service.CategoryService;
import com.muhittinu.blogapp.service.CommentService;
import com.muhittinu.blogapp.service.PostService;
import com.muhittinu.blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {
    private final CategoryService categoryService;
    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //createData();
    }

    private void createData(){
        Category cat1 = Category.builder()
                .name("Yazilim")
                .description("Yazilim ile ilgili icerikler")
                .build();
        Category cat2 = Category.builder()
                .name("Teknoloji")
                .description("Teknoloji ile ilgili icerikler")
                .build();
        Category cat3 = Category.builder()
                .name("Spor")
                .description("Spor ile ilgili icerikler")
                .build();
        Category cat4 = Category.builder()
                .name("TV")
                .description("Tv ile ilgili icerikler")
                .build();
        categoryService.saveAll(List.of(cat1,cat2,cat3,cat4));
        User user1 = User.builder()
                .firstName("Mehmet")
                .lastName("Kaya")
                .username("mehmetk")
                .email("mehmetk@gmail.com")
                .password("159Pass.")
                .photo("")
                .favCategories(List.of(cat1,cat2,cat4))
                .build();
        User user2 = User.builder()
                .firstName("Ahmet")
                .lastName("Kara")
                .username("ahmetk")
                .email("ahmetk@gmail.com")
                .password("159Pass.")
                .photo("")
                .favCategories(List.of(cat1,cat2,cat4))
                .build();
        User user3 = User.builder()
                .firstName("Bahar")
                .lastName("Ak")
                .username("bahara")
                .email("bahara@gmail.com")
                .password("159Pass.")
                .photo("")
                .favCategories(List.of(cat2,cat3,cat4))
                .build();
        userService.saveAll(List.of(user1,user2,user3));
        Post post1 = Post.builder()
                .userid(1L)
                .category(cat1)
                .header("Yazılım Geliştirme Süreci ve Aşamaları")
                .context("Giriş:\n" +
                        "Yazılım geliştirme, teknolojik yeniliklerin ve ürünlerin ortaya çıkmasını sağlayan karmaşık bir süreçtir. Bu yazıda, yazılım geliştirme sürecinin aşamalarını adım adım ele alarak, her bir aşamanın önemini ve süreçteki rolünü açıklayacağız.\n" +
                        "\n" +
                        "1. Gereksinim Analizi:\n" +
                        "Yazılım geliştirme sürecinin ilk adımı, müşteri veya kullanıcı ihtiyaçlarını anlamak ve gereksinimleri belirlemektir. Bu aşamada, gereksinim toplama teknikleri ve gereksinim belgelendirme süreçleri üzerinde durabilirsiniz.\n" +
                        "\n" +
                        "2. Tasarım Aşaması:\n" +
                        "Gereksinimlerin belirlenmesinin ardından, yazılımın mimari yapısı, veri akışı ve kullanıcı arayüzü gibi unsurların tasarımı yapılır. Yazılım tasarım prensipleri ve en iyi uygulamaları bu bölümde ele alınabilir.\n" +
                        "\n" +
                        "3. Geliştirme ve Kodlama:\n" +
                        "Tasarım aşamasında oluşturulan plana dayanarak, yazılım geliştiricileri tarafından kodlama işlemi gerçekleştirilir. Programlama dilleri, yazılım geliştirme araçları ve yaklaşımları burada vurgulanabilir.\n" +
                        "\n" +
                        "4. Test Etme ve Doğrulama:\n" +
                        "Yazılımın doğruluğunu ve kalitesini sağlamak için test aşaması önemlidir. Farklı test yöntemleri, hata ayıklama süreçleri ve test senaryoları üzerinde durulabilir.\n" +
                        "\n" +
                        "5. Dağıtım ve Uygulama:\n" +
                        "Yazılım, kullanıcılara sunulmadan önce, dağıtım ve uygulama aşamasından geçer. Bu aşamada, yayınlama süreçleri, güncelleme stratejileri ve dağıtım platformları incelenebilir.\n" +
                        "\n" +
                        "6. Bakım ve Destek:\n" +
                        "Yazılımın yayınlanmasının ardından, kullanıcı geri bildirimleri ve bakım süreçleriyle ilgili çalışmalar devam eder. Yazılımın sürekli olarak güncellenmesi ve desteklenmesi bu aşamada önemlidir.\n" +
                        "\n" +
                        "Sonuç:\n" +
                        "Yazılım geliştirme süreci, bir döngü olarak devam eder ve sürekli iyileştirme gerektirir. Bu sürecin her aşaması, başarılı bir ürün ortaya çıkarmak için önemlidir. Yazılım geliştirme sürecinin bu adımlarını anlamak, başarılı bir geliştirme projesi için temel bir adımdır.")
                .build();
    }
}
