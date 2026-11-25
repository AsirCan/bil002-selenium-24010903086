# language: tr
Özellik: Form elemanları (açılır liste ve onay kutuları)
  Bir kullanıcı olarak, açılır listeden seçim yapabilmek ve onay kutularını işaretleyebilmek istiyorum.

  Senaryo taslağı: Açılır listeden seçenek seçilir
    Diyelim ki kullanıcı açılır liste sayfasındadır
    Eğer ki kullanıcı listeden "<seçenek>" seçeneğini seçer
    O zaman seçili seçenek "<seçenek>" olur

    Örnekler:
      | seçenek  |
      | Option 1 |
      | Option 2 |

  Senaryo: Yer tutucu seçenek seçilemez ve başlangıçta seçilidir
    Diyelim ki kullanıcı açılır liste sayfasındadır
    O zaman seçili seçenek "Please select an option" olur
    Ve "Please select an option" seçeneği seçilemez durumdadır

  Senaryo: Onay kutuları tıklanınca durum değiştirir
    Diyelim ki kullanıcı onay kutuları sayfasındadır
    Eğer ki kullanıcı 1. onay kutusuna tıklar
    Ve kullanıcı 2. onay kutusuna tıklar
    O zaman 1. onay kutusu işaretli olur
    Ve 2. onay kutusu işaretsiz olur
