package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.domain.repository.UserRepository
import javax.inject.Inject

class GetUserFromSharedPrefsUseCase @Inject constructor(private val userRepository: UserRepository){
    fun execute(): SavedUser {
        return userRepository.checkUser()
    }
}