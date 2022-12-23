package ir.maktab.question1.service.impl;

import ir.maktab.question1.data.Person;
import ir.maktab.question1.repository.PersonRepository;
import ir.maktab.question1.service.PersonService;

public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository = new PersonRepository();

    @Override
    public void creat(Person person) {
        personRepository.creat(person);
    }
}
