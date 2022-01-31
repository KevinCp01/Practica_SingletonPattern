import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import SingletonConnection.SingletonConnection;

/**
 * ================ PRACTICA CONEXION A DB CON PATRON SINGLETON  ================
 * 
 * @author Kevin Campa Alvarado
 *  Grupo: IDGS101N
 *  Fecha: 30/01/2022
 */

public class Main {

    public static void main(String args[]){
        
        try {

            // INSTANCIAMOS LA CLASE SINGLETON Y LLAMAMOS AL GETCONNECTION()
            Connection singletonConnection = SingletonConnection.getInstance().getConnection();

            // TABLA PAYERS

            System.out.println("\n\t============== TABLA PLAYERS ==============\n");
            // SELECT
            System.out.println("---SELECT-----------------");
            ResultSet resultSet = singletonConnection.createStatement().executeQuery("SELECT * FROM players");
            while(resultSet.next()){
                System.out.println("ID Player: "+resultSet.getString(1)+" | Nickname: "+resultSet.getString(2)+" | E-mail: "+resultSet.getString(3));
            }
            System.out.println();


            // INSERT
            System.out.println("---INSERT-----------------\n");
            singletonConnection.createStatement()
                    .execute("INSERT INTO players VALUES (0,'Pepe','Pepejuega@gmail.com')");
            resultSet = singletonConnection.createStatement().executeQuery("SELECT * FROM players");
            while (resultSet.next()) {
                System.out.println("ID Player: " + resultSet.getString(1) + " | Nickname: " + resultSet.getString(2)
                        + " | E-mail: " + resultSet.getString(3));
            }
            System.out.println();


            //UPDATE
            System.out.println("---UPDATE-----------------\n");
            singletonConnection.createStatement()
                    .execute("UPDATE players SET nickname = 'Pocholo', player_email = 'pocholin69@gmail.com' WHERE player_id = 3");
            resultSet = singletonConnection.createStatement().executeQuery("SELECT * FROM players");
            while (resultSet.next()) {
                System.out.println("ID Player: " + resultSet.getString(1) + " | Nickname: " + resultSet.getString(2)
                        + " | E-mail: " + resultSet.getString(3));
            }
            System.out.println();


            //DELETE
            System.out.println("---DELETE-----------------\n");
            singletonConnection.createStatement()
                    .execute(
                            "DELETE FROM players WHERE player_id = 1");
            resultSet = singletonConnection.createStatement().executeQuery("SELECT * FROM players");
            while (resultSet.next()) {
                System.out.println("ID Player: " + resultSet.getString(1) + " | Nickname: " + resultSet.getString(2)
                        + " | E-mail: " + resultSet.getString(3));
            }
            System.out.println();

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // TABLA MAPS
            Connection singletonConnection2 = SingletonConnection.getInstance().getConnection();

            System.out.println("\n\t============== TABLA MAPS ==============\n");
            // SELECT 2
            System.out.println("---SELECT-----------------");
            resultSet = singletonConnection2.createStatement().executeQuery("SELECT * FROM maps");
            while (resultSet.next()) {
                System.out.println("Map ID: " + resultSet.getString(1) + " | Map Name: " + resultSet.getString(2)
                        + " | Description: " + resultSet.getString(3));
            }
            System.out.println();

            // INSERT
            System.out.println("---INSERT-----------------\n");
            singletonConnection2.createStatement()
                    .execute("INSERT INTO maps VALUES (0,'Kokiri Forest','Un denso bosque repleto de creaturas y una melodia peculiar...')");
            resultSet = singletonConnection2.createStatement().executeQuery("SELECT * FROM maps");
            while (resultSet.next()) {
                System.out.println("Map ID: " + resultSet.getString(1) + " | Map Name: " + resultSet.getString(2)
                        + " | Description: " + resultSet.getString(3));
            }
            System.out.println();

            // UPDATE
            System.out.println("---UPDATE-----------------\n");
            singletonConnection2.createStatement()
                    .execute(
                            "UPDATE maps SET map_name = 'Ruins', map_desc = 'Un lugar al que nadie buscaria acceder, ¿Que haces aqui?!!' WHERE map_id = 1");
            resultSet = singletonConnection2.createStatement().executeQuery("SELECT * FROM maps");
            while (resultSet.next()) {
                System.out.println("Map ID: " + resultSet.getString(1) + " | Map Name: " + resultSet.getString(2)
                        + " | Description: " + resultSet.getString(3));
            }
            System.out.println();

            // DELETE
            System.out.println("---DELETE-----------------\n");
            singletonConnection2.createStatement()
                    .execute(
                            "DELETE FROM maps WHERE map_id = 2");
            resultSet = singletonConnection2.createStatement().executeQuery("SELECT * FROM maps");
            while (resultSet.next()) {
                System.out.println("Map ID: " + resultSet.getString(1) + " | Map Name: " + resultSet.getString(2)
                        + " | Description: " + resultSet.getString(3));
            }
            System.out.println();
            
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        
        

        


    }

}