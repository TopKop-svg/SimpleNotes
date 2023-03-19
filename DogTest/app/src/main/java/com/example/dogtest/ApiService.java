package com.example.dogtest;

import io.reactivex.rxjava3.core.Single;

public interface ApiService {
    Single<DogImage> loadDogImage();
}
