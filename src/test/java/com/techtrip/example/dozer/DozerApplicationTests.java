package com.techtrip.example.dozer;

import com.techtrip.example.dozer.converters.MegaDateConverter;
import com.techtrip.example.dozer.model.NewFangledWidget;
import com.techtrip.example.dozer.model.OriginalWidget;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DozerApplicationTests.DozerApplicationTestConfiguration.class)
public class DozerApplicationTests {

	public static Logger LOGGER = LoggerFactory.getLogger(DozerApplicationTests.class);

	@Autowired
	private DozerBeanMapperFactoryBean dozerBean;

	@Autowired
	OriginalWidget expectedOriginalWidget;

	@Autowired
	NewFangledWidget expectedNewfangledWidget;

	@Test
	public void expectedOriginalWidgetIsInstantiated() {
		assertThat(expectedOriginalWidget).isNotNull();
		LOGGER.info(expectedOriginalWidget.toString());
	}

	@Test
	public void expectedNewfangledWidgetIsInstantiated() {
		assertThat(expectedNewfangledWidget).isNotNull();
		LOGGER.info(expectedNewfangledWidget.toString());
	}

	@Test
	public void tetOriginalWidgetToNewFangledWidget() throws Exception {

		org.dozer.Mapper mapper = dozerBean.getObject();

		NewFangledWidget target = NewFangledWidget.newBuilder().build();
		//map expectedOriginalWidget: OriginalWidget to expectedNewfangledWidget: TargetWidget using "dozer-bean-mappings.xml" map-id: widget
		mapper.map(expectedOriginalWidget, target, "widget");

		LOGGER.info(expectedOriginalWidget.toString());
		LOGGER.info(target.toString());

//		Assert.assertEquals(p1Domain.getName(), p1Dto.getNameFull());
//		Assert.assertEquals(p1Domain.getAge(), p1Dto.getAgeThisYear());
	}

	@Test
	public void testNewFangledWidgetToOriginalWidget() throws Exception {

		org.dozer.Mapper mapper = dozerBean.getObject();

		OriginalWidget target = OriginalWidget.newBuilder().build();
		//map expectedOriginalWidget: OriginalWidget to expectedNewfangledWidget: TargetWidget using "dozer-bean-mappings.xml" map-id: widget
		mapper.map(expectedNewfangledWidget, target, "widget");

		LOGGER.info(expectedNewfangledWidget.toString());
		LOGGER.info(target.toString());

//		Assert.assertEquals(p1Domain.getName(), p1Dto.getNameFull());
//		Assert.assertEquals(p1Domain.getAge(), p1Dto.getAgeThisYear());
	}

	@TestConfiguration
	public static class DozerApplicationTestConfiguration {

		@Bean
		public NewFangledWidget targetBean() {
			return NewFangledWidget.newBuilder().withName("Target").withOriginationDate(LocalDateTime.now()).withIdentifier(1).build();
		}

		@Bean
		public OriginalWidget sourceBean() {
			return OriginalWidget.newBuilder().withCreationDate(Calendar.getInstance().getTime()).withId(1).withName("Source").build();
		}

		@Bean(name="megaDateConverter")
		public MegaDateConverter<LocalDateTime> megaDateConverter() {
			return new MegaDateConverter(LocalDateTime.class);
		}

		@Bean
		public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath*:mappings/*mappings.xml") Resource[] resources) throws Exception {
			final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
			// Other configurations
			dozerBeanMapperFactoryBean.setMappingFiles(resources);
			return dozerBeanMapperFactoryBean;
		}
	}

}
