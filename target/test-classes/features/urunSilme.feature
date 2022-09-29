Feature: Sepetten urun silme
  @urunsilme
  Scenario Outline: Kullanici urun arar secer sepete ekler ve siler

    Given e-bebek anasayfasina gidilir
    When  arama cubuguna "<searchProduct>" yazilir ve aratilir
    And   cikan ilk urune tiklanir
    And   ilgili urun sepete eklenir
    Then  sepete eklendigi kontrol edilir
    When  ilgili urun sepetten silinir
    Then  sepetin bos oldugu kontrol edilir

    Examples:
      |searchProduct|
      |biberon|


