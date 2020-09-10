package com.stock.companyservice.service;

import com.stock.companyservice.dao.CompanyDao;
import com.stock.companyservice.dto.CompanyDto;
import com.stock.companyservice.model.Company;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.lang.reflect.Type;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;
    private ModelMapper modelMapper;

    public CompanyServiceImpl (CompanyDao companyDao,ModelMapper modelMapper)
    {
        this.companyDao=companyDao;
        this.modelMapper=modelMapper;
    }


    @Override
    public Iterable<CompanyDto> getAllCompanies() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
        List<CompanyDto> dtoList=modelMapper.map(companyDao.findAll(),listType);
        return dtoList;
    }

    @Override
    public CompanyDto addCompany(CompanyDto companyDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Company company = companyDao.save(modelMapper.map(companyDto,Company.class));
        return modelMapper.map(company,CompanyDto.class);
    }

    @Override
    public void deleteCompany(Integer companyId) {
        Company company=companyDao.findByCompanyId(companyId).get();
        companyDao.delete(company);

    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto, Integer companyId) {
        Company company = companyDao.findByCompanyId(companyId).get();
        company.setCompanyName(companyDto.getCompanyName());
        company.setCeo(companyDto.getCeo());
        company.setBoardOfDirectors(companyDto.getBoardOfDirectors());
        company.setDescription(companyDto.getDescription());
        company.setSector(companyDto.getSector());
        company.setStockExchanges(companyDto.getStockExchanges());
        company.setCodeInStockExchange(companyDto.getCodeInStockExchange());
        companyDao.save(company);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(company,CompanyDto.class);
    }

    @Override
    public List<CompanyDto> searchByPattern(String pattern) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType=new TypeToken<List<CompanyDto>>(){}.getType();
        List<CompanyDto> dtoList=modelMapper.map(companyDao.findByCompanyNameContaining(pattern),listType);
        return dtoList;
    }
}
