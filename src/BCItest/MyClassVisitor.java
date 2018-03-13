package BCItest;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.TypePath;

public class MyClassVisitor extends ClassVisitor {

	public MyClassVisitor(int arg0) {
		super(arg0);
	}

	@Override
	public void visit(int version, int access, String name,
			String signature, String superName, String[] interfaces) {
		super.visit(version, access, name, signature, superName, interfaces);
		System.out.println(name + " extends " + superName + " {");
	}

	@Override
	public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
		return super.visitAnnotation(arg0, arg1);
	}

	@Override
	public void visitAttribute(Attribute arg0) {
		super.visitAttribute(arg0);
	}

	@Override
	public void visitEnd() {
		super.visitEnd();
		System.out.println("}");
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc,
			String signature, Object value) {
		System.out.println(" " + desc + " " + name);
		return super.visitField(access, name, desc, signature, value);
	}

	@Override
	public void visitInnerClass(String name, String outerName,
			String innerName, int acces) {
		super.visitInnerClass(name, outerName, innerName, acces);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name,
			String desc, String signature, String[] exceptions) {
		System.out.println(" " + name + desc);
		return super.visitMethod(access, name, desc, signature, exceptions);
	}

	@Override
	public void visitOuterClass(String arg0, String arg1, String arg2) {
		super.visitOuterClass(arg0, arg1, arg2);
	}

	@Override
	public void visitSource(String arg0, String arg1) {
		super.visitSource(arg0, arg1);
	}

	@Override
	public AnnotationVisitor visitTypeAnnotation(int arg0, TypePath arg1,
			String arg2, boolean arg3) {
		return super.visitTypeAnnotation(arg0, arg1, arg2, arg3);
	}

}
