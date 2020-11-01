package pl.maakaa.swaggerCodegen;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.maakaa.swaggerCodegen.model.Album;
import pl.maakaa.swaggerCodegen.service.DefaultApiDelegateService;
import pl.maakaa.swaggerCodegen.model.Band;
import pl.maakaa.swaggerCodegen.model.Genre;

import java.util.List;
import java.util.Optional;

/**
 * Class simulating a database.
 */
@Setter
@Getter
@Service
public class DatabaseStub implements DefaultApiDelegateService {

    private List<Album> list;

    public DatabaseStub(List<Album> list) {
        this.list = list;
    }

    @Override
    public List<Album> getAlbums() {
        Band minskBand = new Band();
        minskBand.setId(1L);
        minskBand.setName("Minsk");

        Album album1 = new Album();
        album1.setId(1L);
        album1.setGenre(Genre.METAL);
        album1.setTitle("Out of a Center Which Is Neither Dead Nor Alive");
        album1.setBand(minskBand);

        Album album2 = new Album();
        album2.setId(2L);
        album2.setGenre(Genre.METAL);
        album2.setTitle("With Echoes in the Movement of Stone");
        album2.setBand(minskBand);

        list.add(album1);
        list.add(album2);
        return list;
    }

    @Override
    public Album showAlbumById(Long albumId) {
        Optional<Album> album = list.stream()
                .filter(a -> a.getId().equals(albumId))
                .findAny();
        return album.orElseGet(album::get);
    }

    @Override
    public void createAlbum(Album album) {
        list.add(album);
    }

    @Override
    public void deleteAlbumById(Long albumId) {
        Optional<Album> album = list.stream()
                .filter(a -> a.getId().equals(albumId))
                .findAny();

        if (album.isPresent()) {
            list.remove(album.get());
            System.out.println("Album id=" + albumId + " removed");
        } else {
            System.out.println("Cannot find album with id " + albumId);
        }
    }

    @Override
    public void updateAlbumById(Long albumId, String title) {
        Optional<Album> album = list.stream()
                .filter(a -> a.getId().equals(albumId))
                .findAny();

        if (album.isPresent()) {
            album.get().setTitle(title);
            System.out.println("Album id=" + albumId + " updated");
        } else {
            System.out.println("Cannot find album with id " + albumId);
        }
    }
}
