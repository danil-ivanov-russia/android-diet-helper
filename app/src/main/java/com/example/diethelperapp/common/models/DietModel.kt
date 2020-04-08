package com.example.diethelperapp.common.models

interface DietModel {
    var dietId: Int
    var dietName: String?
    var supportingInformation: String?
    var duration: Int
}