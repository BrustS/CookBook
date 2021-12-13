package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.models.User
import by.brust.cookbook.domain.repository.UserRepository
import javax.inject.Inject

class RegistrationUserUseCase @Inject constructor(private val userRepository: UserRepository) {
   suspend fun execute(user: User) {
        return userRepository.addUser(user)
    }
}