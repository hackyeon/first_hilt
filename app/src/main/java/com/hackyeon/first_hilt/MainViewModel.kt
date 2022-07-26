package com.hackyeon.first_hilt

import androidx.lifecycle.ViewModel
import com.hackyeon.first_hilt.repository.NaverDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NaverDataRepository): ViewModel() {
}