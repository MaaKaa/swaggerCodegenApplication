package pl.maakaa.swaggerCodegen.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.maakaa.swaggerCodegen.model.Album;
import pl.maakaa.swaggerCodegen.service.DefaultApiDelegateService;
import pl.maakaa.swaggerCodegen.api.DefaultApiDelegate;
import pl.maakaa.swaggerCodegen.model.Album;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Business logic for the API methods.
 */
@Service
@RequiredArgsConstructor
public class DefaultApiDelegateImpl implements DefaultApiDelegate {

    private final DefaultApiDelegateService defaultApiDelegateService;

    @Override
    public ResponseEntity<List<Album>> getAlbums() {
        List<Album> list = defaultApiDelegateService.getAlbums();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<Album> showAlbumById(@Min(1L) Long albumId) {
        Album album = defaultApiDelegateService.showAlbumById(albumId);
        return ResponseEntity.ok(album);
    }

    @Override
    public ResponseEntity<Void> createAlbum(@Valid Album body) {
        defaultApiDelegateService.createAlbum(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAlbumById(@Min(1L) Long albumId) {
        defaultApiDelegateService.deleteAlbumById(albumId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateAlbumById(@Min(1L) Long albumId, String title) {
        defaultApiDelegateService.updateAlbumById(albumId, title);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
