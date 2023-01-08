package com.yuan.RandomSelection.service;

import org.springframework.stereotype.Service;

/**
 * @avthor yuan8
 * @Date 2023/1/5
 */
@Service
public class RandomImpl implements RandomService {
    public String random(String[] people) {
        int i = (int) (Math.random() * (people.length - 1));
        System.out.println(people[i]);
        return people[i];
    }
}