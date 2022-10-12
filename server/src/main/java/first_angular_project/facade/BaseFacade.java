package first_angular_project.facade;

import first_angular_project.view.dto.request.RequestDto;
import first_angular_project.view.dto.response.ResponseDto;

import java.util.List;

public interface BaseFacade <REQ extends RequestDto, RES extends ResponseDto> extends MainFacade {
    void create(REQ req);
    void update(REQ req, long id);
    void delete(long id);
    RES findById(long id);
    List<RES> findAllEntity();
}