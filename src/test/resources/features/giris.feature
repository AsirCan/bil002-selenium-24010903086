# language: tr
Özellik: Güvenli alana giriş ve çıkış
  Bir kullanıcı olarak, doğru bilgilerle güvenli alana girebilmek,
  yanlış bilgilerde anlaşılır bir hata mesajı görmek ve oturumu kapatabilmek istiyorum.

  Geçmiş:
    Diyelim ki kullanıcı giriş sayfasındadır

  Senaryo: Geçerli bilgilerle giriş yapılır
    Eğer ki kullanıcı adı "tomsmith" ve şifre "SuperSecretPassword!" ile giriş yapar
    O zaman güvenli alan sayfası açılır
    Ve "You logged into a secure area!" başarı mesajı görünür

  Senaryo taslağı: Hatalı bilgilerle giriş yapılamaz
    Eğer ki kullanıcı adı "<kullanıcı>" ve şifre "<şifre>" ile giriş yapar
    O zaman giriş sayfasında kalınır ve "<hata mesajı>" hata mesajı görünür

    Örnekler:
      | kullanıcı | şifre                | hata mesajı               |
      | tomsmith  | yanlisSifre          | Your password is invalid! |
      | ahmet     | SuperSecretPassword! | Your username is invalid! |
      | TOMSMITH  | SuperSecretPassword! | Your username is invalid! |
      |           |                      | Your username is invalid! |

  Senaryo: Giriş yapan kullanıcı çıkış yapabilir
    Eğer ki kullanıcı adı "tomsmith" ve şifre "SuperSecretPassword!" ile giriş yapar
    Ve kullanıcı çıkış yapar
    O zaman giriş sayfasına dönülür ve "You logged out of the secure area!" mesajı görünür
