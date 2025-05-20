package gr.netmechanics.jmix.appcommons.entity.util;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;

/**
 * @author Panos Bariamis (pbaris)
 */
public class DoNotCreateCustomizer implements DescriptorCustomizer {
    @Override
    public void customize(final ClassDescriptor descriptor) {
        descriptor.getAlias(); // just to trigger customization
        descriptor.setShouldBeReadOnly(true);
        descriptor.getQueryManager().setInsertCall(null);
        descriptor.getQueryManager().setUpdateCall(null);
        descriptor.getQueryManager().setDeleteCall(null);
    }
}
