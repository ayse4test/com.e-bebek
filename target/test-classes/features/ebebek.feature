Feature: Urun arama ve sepet islemleri
  @ebebek
  Scenario Outline: Kullanici istedigi urunu arar secer sepetine ekle cikar yapar

    Given e-bebek anasayfasina gidilir
    When   arama cubuguna "<searchProduct>" yazilir ve aratilir
    And  cikan ilk urune tiklanir
    And   ilgili urun sepete eklenir
    Then  sepete eklendigi kontrol edilir
    When   sepette urun sayisi 1 kez arttirilir
    Then  urun sayisinin arttigi gorulur
    When   sepette urun sayisi 1 kez azaltilir
    Then  urun sayisinin azaldigi gorulur
    When   ilgili urun sepetten silinir
    Then  sepetin bos oldugu kontrol edilir

  Examples:
  |searchProduct|
  | biberon      |






    #1- E-bebek ana sayfasına gidilir (https://www.e-bebek.com/)
    #2- Arama çubuğuna “biberon” yazılır ve aratılır
    #3- Çıkan ilk ürüne tıklanır
    #4- İlgili ürün sepete eklenir
    #5- Sepete eklendiği kontrol edilir
    #6- Sepette ürün sayısı 2 kez arttırılır
    #7- Ürün sayısının arttığı görülür.
    #8- Sepette ürün sayısı 2 kez azaltılır
    #9- Ürün sayısının azaldığı görülür.
    #10- İlgili ürün sepetten silinir.
    #11- Sepetin boş olduğu kontrol edilir.