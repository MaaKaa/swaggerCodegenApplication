package pl.maakaa.swaggerCodegen.service;

import pl.maakaa.swaggerCodegen.model.Album;
import java.util.List;

public interface DefaultApiDelegateService {

    List<Album> getAlbums();
    Album showAlbumById(Long albumId);
    void createAlbum(Album body);
    void deleteAlbumById(Long albumId);
    void updateAlbumById(Long albumId, String title);
}
