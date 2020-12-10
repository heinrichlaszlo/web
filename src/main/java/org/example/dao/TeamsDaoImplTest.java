package org.example.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class TeamsDaoImplTest {

    @InjectMocks
    private TeamsDaoImpl dao;
    @Mock
    private TeamsRepository teamsRepository;

}
