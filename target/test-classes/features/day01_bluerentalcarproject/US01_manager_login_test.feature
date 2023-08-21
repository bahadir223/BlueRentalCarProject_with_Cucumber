  #USER STORY : US167854_manager_login_test
  #NAME:kullanici tum manager login bilgileri ile giris yapabilmeli
  #AC
    #Given kullanici ana sayfada
    #When kullanici login sayfasina gider
    #And kullanici adini girer ->>>>> parametre
    #And sifreyi girer ->>>>>parametre
    #And login butonuna basar
    #Then login islemi gerceklesir
    #Giris yapildigini dogrula
    #Cikis Yap
    #url : https://www.bluerentalcars.com/

  #| email                         | password  |
  #| sam.walker@bluerentalcars.com | c!fas_art |
  #| kate.brown@bluerentalcars.com | tad1$Fas  |

  Feature: US01_manager_login_test

    Scenario Outline:kullanici tum manager login bilgileri ile giris yapabilmeli
      Given kullanici "bluerentalcarsuRL" sayfasina properties ile gider
      Then kullanici login butonuna tiklar
      Then kullanici bilgilerini girer "<email>","<password>"
      Then kullanici 3 saniye bekler
      Then kullanici giris yapildigini dogrular
      Then kullanici 2 saniye bekler
      Then kullanici sag yukaridaki ismin altindaki profil butonuna basar
      Then kullanici 2 saniye bekler
      Then exceldeki "kullanici_bilgileri" sayfasindaki bilgileri kullanarak profilini gunceller
      Then kullanici 2 saniye bekler
      Then kullanici bilgilerinin guncellendigini dogrular
      And sayfayi kapatir

      Examples:
        | email                         | password  |
        | sam.walker@bluerentalcars.com | c!fas_art |
        | kate.brown@bluerentalcars.com | tad1$Fas  |