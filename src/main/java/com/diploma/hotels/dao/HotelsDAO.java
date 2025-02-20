package com.diploma.hotels.dao;

import com.diploma.hotels.models.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HotelsDAO {

    private final DataSource dataSource;

    public List<Hotel> getHotels() {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels");
            ResultSet rs = statement.executeQuery();
            List<Hotel> hotelList = new ArrayList<>();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("rating"),
                        null,
                        null,
                        null
                );
                hotelList.add(hotel);
            }
            return hotelList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List <Hotel> getFreeHotels(LocalDate checkIn, LocalDate checkOut) {
        try (Connection connection =  dataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT h.id "+
                        ", h.name "+
                        ", o.id "+
                        ", o.room_id "+
                        ", o.check_in "+
                        ", o.check_out "+
                        ", r.id "+
                        ", r.hotel_id "+
                        ", r.room_number "+
                        ", r.price "+
                        "FROM hotels AS h "+
                        "LEFT JOIN rooms AS r ON r.hotel_id = h.id "+
                        "LEFT JOIN orders  AS o ON o.room_id = r.id "+
                        "AND o.check_out >= DATE(NOW()) "+
                        "WHERE (STR_TO_DATE(?, '%d-%m-%Y') >= o.check_out OR STR_TO_DATE(?, '%d-%m-%Y') <= o.check_in) "+
                        "OR o.room_id IS NULL "+
                        "AND r.hotel_id IS NOT NULL;"
            );

            statement.setDate(1, Date.valueOf(checkIn));
            statement.setDate(2, Date.valueOf(checkOut));

            ResultSet rs = statement.executeQuery();
            List<Hotel> hotelList = new ArrayList<>();
            while (rs.next()){
                Hotel hotel = new Hotel(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("rating"),
                        null,
                        null,
                        null
                );
                hotelList.add(hotel);
            }

            return hotelList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
    use booking;

    //SET @check_in_var = DATE(NOW());
    //SET @check_out_var = DATE_ADD(DATE(NOW()), INTERVAL 4 DAY);

    "SELECT h.id"+
         ", h.name"+
         ", o.id"+
         ", o.room_id"+
         ", o.check_in"+
         ", o.check_out"+
         ", r.id"+
         ", r.hotel_id"+
         ", r.room_number"+
         ", r.price"+
      "FROM hotels AS h"+
      "LEFT JOIN rooms AS r ON r.hotel_id = h.id"+
      "LEFT JOIN orders  AS o ON o.room_id = r.id"+
            "AND o.check_out >= DATE(NOW())"+
     "WHERE (? >= o.check_out OR ? <= o.check_in)"+
        "OR o.room_id IS NULL"+
        "AND r.hotel_id IS NOT NULL;"
*/