package com.abdelrahman.kotlincleanarch.presentation.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.abdelrahman.kotlincleanarch.domain.entities.BlogDomain
import com.abdelrahman.kotlincleanarch.domain.repositories.BlogRepository
import com.abdelrahman.kotlincleanarch.presentation.mapper.PresentationResourceMapper
import com.abdelrahman.kotlincleanarch.presentation.model.BlogUi
import com.abdelrahman.kotlincleanarch.presentation.resource.PresentationResource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 03-Oct-20
 * @Project : com.pharmashop.presentation.viewmodels
 */
class BlogsViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val blogsMapper: PresentationResourceMapper<BlogDomain, BlogUi>,
    private val blogRepository: BlogRepository
) : ViewModel() {
    private val _blogs: MutableLiveData<PresentationResource<List<BlogUi>>> =
        MutableLiveData()

    val blogs: LiveData<PresentationResource<List<BlogUi>>>
        get() = _blogs

    fun getBlogs() {
        viewModelScope.launch {
            _blogs.value = PresentationResource.loading()
            try {
                 blogRepository.getBlogs()
                     .map { blogsMapper.mapList(it) }
                    .onEach {
                        _blogs.value = it }
                     .catch {
                         _blogs.value = PresentationResource.domainError(it)
                     }
                    .launchIn(viewModelScope)

            } catch (e: Exception) {
                _blogs.value = PresentationResource.domainError(e)
            }

        }
    }
}