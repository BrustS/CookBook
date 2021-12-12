package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.models.User
import by.brust.cookbook.domain.repository.UserRepository
import javax.inject.Inject

class RegistrationUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    fun execute(user: User): Boolean {
        return userRepository.addUser(user)
    }
}