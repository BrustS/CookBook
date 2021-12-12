package by.brust.cookbook.presentation.ui.view.registration

import androidx.lifecycle.ViewModel
import by.brust.cookbook.domain.usecases.RegistrationUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val registrationUserUseCase: RegistrationUserUseCase) :
    ViewModel() {

}