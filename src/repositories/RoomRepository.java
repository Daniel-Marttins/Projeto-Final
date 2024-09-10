package repositories;

import models.Room;

import java.util.List;

public interface RoomRepository {

    public void saveRoom(String file);
    public Room getRoomById(String file);
    public Room getRoomByLogin(String file);
    public List<Room> getAllRoom(String filePath);
    public Room updateRoom(String file);
    public void deleteRoom(String email, String password);

}
