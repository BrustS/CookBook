package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.repository.UserRepositoryImpl
import by.brust.cookbook.domain.models.LoginigUser
import by.brust.cookbook.domain.repository.UserRepository
import javax.inject.Inject

class LoginUserByEmailUseCase @Inject constructor (private val userRepository: UserRepository) {

    suspend fun execute(email: String, password: String): LoginigUser? {
        return userRepository.getUser(email = email, password = password)
    }
}