package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.domain.models.LoginigUser
import by.brust.cookbook.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserToSharedPrefUserCase @Inject constructor(private val userRepository: UserRepository) {
    fun execute(savedUser: SavedUser) {
        userRepository.saveUser(savedUser)
    }
}