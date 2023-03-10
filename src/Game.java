import java.util.Scanner;

public class Game
{
    private Scanner input = new Scanner(System.in);

    public void start()
    {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sevgili " + player.getName() + " Hoşgeldiniz !");

        System.out.println("Lütfen bir karakter seçiniz !");
        System.out.println("--------------------------------------------");
        player.selectChar();

        Location location = null;

        while(true)
        {
            player.printInfo();
            System.out.println();
            System.out.println("Bölgeler");
            System.out.println("--------------------------------------------");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Market");
            System.out.println("3 - Mağara-> Ödül yemek");
            System.out.println("4 - Orman-> Ödül odun");
            System.out.println("5 - Nehir-> Ödül su");
            System.out.println("6 - Maden-> Ödül süpriz");

            System.out.println("0 - Çıkış yap -> Oyunu sonlandır");
            System.out.println("--------------------------------------------");
            first:
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selecLoc = input.nextInt();
            //boolean state=true;
            switch (selecLoc)
            {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if(player.getInventory().searchAward("Food")==true)
                    {
                        System.out.println("Bu bölümü tamamladınız!");
                        System.out.println("Tekrar giriş yapamazsınız!");
                        continue;
                    }
                   else
                    {
                        location = new Cave(player);

                    }
                   break;
                case 4:
                    if(player.getInventory().searchAward("Firewood")==true)
                    {
                        System.out.println("Bu bölümü tamamladınız!");
                        System.out.println("Tekrar giriş yapamazsınız!");
                        continue;
                    }
                    else
                    {
                        location = new Forest(player);

                    }
                    break;
                case 5:
                    if(player.getInventory().searchAward("Water")==true)
                    {
                        System.out.println("Bu bölümü tamamladınız!");
                        System.out.println("Tekrar giriş yapamazsınız!");
                        continue;
                    }
                    else
                    {
                        location = new River(player);

                    }
                    break;
                case 6:
                    if(player.getInventory().searchAward("Suprise")==true)
                    {
                        System.out.println("Bu bölümü tamamladınız!");
                        System.out.println("Tekrar giriş yapamazsınız!");
                        continue;
                    }
                    else
                    {
                        location = new Mine(player);

                    }
                    break;

                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz!");

            }
            /*if(location == null)
            {
                System.out.println("Oyun bitti!");
                break;
            }*/

            if(!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }
            if(player.getInventory().searchAward("Food")==true &&
                    player.getInventory().searchAward("Firewood")==true &&
                    player.getInventory().searchAward("Water")==true)
            {
                System.out.println("");
                System.out.println("**********CONGRULATIONS********");
                System.out.println("Tebrikler tüm bölümleri tamamlayarak oyunu kazandınız!");
                break;
            }

        }

    }

}
