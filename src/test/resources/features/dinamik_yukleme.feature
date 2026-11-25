# language: tr
Özellik: Dinamik yüklenen içerik
  Bir kullanıcı olarak, Start düğmesine bastığımda yükleme bitince sonucun görünmesini istiyorum.
  (Explicit wait: sonuç birkaç saniye sonra geliyor; sabit bekleme kullanılmıyor.)

  Senaryo taslağı: Yükleme sonunda "Hello World!" görünür
    Diyelim ki kullanıcı <örnek> numaralı dinamik yükleme örneğini açar
    Ve henüz hiçbir sonuç metni görünmez
    Eğer ki kullanıcı Start düğmesine basar
    O zaman yükleme bittikten sonra "Hello World!" metni görünür

    Örnekler:
      | örnek | açıklama                                  |
      | 1     | eleman sayfada var ama gizli              |
      | 2     | eleman yükleme sonrası sayfaya ekleniyor  |
