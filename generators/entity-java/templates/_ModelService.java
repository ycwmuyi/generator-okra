package <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.mapper.<%= entityClass %>Mapper;
import <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.model.<%= entityClass %>;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class <%= entityClass %>Service extends ServiceImpl<<%= entityClass %>Mapper, <%= entityClass %>>{


}
