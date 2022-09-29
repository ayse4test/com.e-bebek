Feature: Sepete urun ekleme
  @urunekleme
  Scenario Outline: Kullanici urun arar secer sepete ekler

    Given e-bebek anasayfasina gidilir
    When  arama cubuguna "<searchProduct>" yazilir ve aratilir
    And   cikan ilk urune tiklanir
    And   ilgili urun sepete eklenir
    Then  sepete eklendigi kontrol edilir

    Examples:
    |searchProduct|
    |biberon|


