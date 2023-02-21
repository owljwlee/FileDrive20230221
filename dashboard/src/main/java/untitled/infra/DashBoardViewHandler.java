package untitled.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
public class DashBoardViewHandler {

    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1(
        @Payload FileUploaded fileUploaded
    ) {
        try {
            if (!fileUploaded.validate()) return;

            // view 객체 생성
            DashBoard dashBoard = new DashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            dashBoard.setId(fileUploaded.getId());
            dashBoard.setFileName(fileUploaded.getFileName());
            dashBoard.setFileSize(fileUploaded.getFileSize());
            // view 레파지 토리에 save
            dashBoardRepository.save(dashBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndexedByFileName_then_UPDATE_1(
        @Payload FileIndexedByFileName fileIndexedByFileName
    ) {
        try {
            if (!fileIndexedByFileName.validate()) return;
            // view 객체 조회
            Optional<DashBoard> dashBoardOptional = dashBoardRepository.findById(
                fileIndexedByFileName.getFileId()
            );

            if (dashBoardOptional.isPresent()) {
                DashBoard dashBoard = dashBoardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileVideoStreammed_then_UPDATE_2(
        @Payload FileVideoStreammed fileVideoStreammed
    ) {
        try {
            if (!fileVideoStreammed.validate()) return;
            // view 객체 조회
            Optional<DashBoard> dashBoardOptional = dashBoardRepository.findById(
                fileVideoStreammed.getFileId()
            );

            if (dashBoardOptional.isPresent()) {
                DashBoard dashBoard = dashBoardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setVideoUrl(fileVideoStreammed.getVideoUrl());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
