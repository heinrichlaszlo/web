package org.example.service;

import org.example.dao.TeamsDao;
import org.example.exception.UnknownTeamsException;
import org.example.model.Teams;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


@ExtendWith(MockitoExtension.class)
class TeamsServiceImplTest {

    @InjectMocks
    private TeamsServiceImpl service;
    @Mock
    private TeamsDao dao;


    @Test
    public void testRecordTeams() throws UnknownTeamsException {
        Teams teams = getTeams();


        service.recordTeams(teams);

        verify(dao,times(1)).createTeams(teams);
       }

       @Test
       void testRecordTeamsWithUnknonwName() throws UnknownTeamsException{
            doThrow(UnknownTeamsException.class).when(dao).createTeams(any());

            assertThrows(UnknownTeamsException.class, ()-> {
                service.recordTeams(getTeams());
            });
       }

    private Teams getTeams(){
        return new Teams(
                "Kisvárda"
        );
    }



    @Test
    void testReadAllTeams(){
        when(dao.readAll()).thenReturn(getDefaultTeams());

        Collection<Teams> actual = service.getAllTeams();

       assertThat(getDefaultTeams(), is(actual) );

    }

    private Collection<Teams> getDefaultTeams(){
        return Arrays.asList(
                new Teams(
                        "Kisvárda"
                ),
                new Teams(
                        "Szpari"
                ),
                new Teams(
                        "Alabama KC"
                )
        );
    }
}
